import { createContext, ReactNode, useContext, useState } from 'react'
import useLocalStorage from './useLocalStorage'
import { IUserPermissions } from '../components/UserHasPermission'
import { IMenuItem } from '../types'
import ServiceStorage from '../services/storage'

interface IAuthProviderProps {
    children: ReactNode
}

export interface IUserRoutes {
    name: string
    permissions: IUserPermissions[]
}

export interface UserAuth {
    name: string
    cpf: string
    perfil: string
    esfera?: string
    autenticado: boolean
    unidades: string[]
    ibge?: string
    userRoutes: IUserRoutes[]
    userMenuItems: IMenuItem[]
}

interface IAuthContextData {
    login: (routes: UserAuth) => void
    logout: () => void
    auth: UserAuth
    funcionalidades: number[]
    setFuncionalidades: (ids: number[]) => void
    getFuncionalidades: (id: number) => boolean
}

const userAuthDefaultValues: UserAuth = {
    name: '',
    cpf: '',
    perfil: '',
    esfera: undefined,
    autenticado: false,
    unidades: [],
    ibge: undefined,
    userRoutes: [],
    userMenuItems: [],
}

const AuthContext = createContext({} as IAuthContextData)

function useAuth() {
    return useContext(AuthContext)
}

function AuthProvider({ children }: IAuthProviderProps) {
    const [auth, setAuth] = useLocalStorage('auth', userAuthDefaultValues)
    const [funcionalidades, setPermissoes] = useState<number[]>([])

    function login(auth: UserAuth) {
        return new Promise((resolve, reject) => {
            try {
                setAuth(auth)

                resolve('Login success')
            } catch (error) {
                setAuth({ ...auth, autenticando: false })

                reject(error)
            }
        })
    }

    function logout() {
        setAuth(userAuthDefaultValues)
        window.localStorage.setItem('location', '')
        ServiceStorage.removeToken()
    }

    function getFuncionalidades(id: number) {
        return funcionalidades.includes(id)
    }

    function setFuncionalidades(ids: number[]) {
        setPermissoes(ids)
    }

    return (
        <AuthContext.Provider value={{ login, logout, auth, funcionalidades, setFuncionalidades, getFuncionalidades }}>
            {children}
        </AuthContext.Provider>
    )
}

export { useAuth, AuthProvider }
