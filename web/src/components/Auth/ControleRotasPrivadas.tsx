import { Outlet, useLocation, useNavigate } from 'react-router-dom'

import { useAuth } from '../../hooks/useAuth'
// import { IRotas, RotasPrivadas } from '../../routes/RotasPrivadas'
// import { AccessDenied } from './AccessDenied'
import { useEffect } from 'react'
import ServiceStorage from '../../services/storage'

// function findAbsolutePath(routes: IRotas[], currentRoute: string, path = ''): boolean {
//     return routes.some((route) => {
//         path += route.path

//         if (path === currentRoute) {
//             return true
//         }

//         if (route.children) {
//             return findAbsolutePath(route.children, currentRoute, path + '/')
//         }

//         path = ''

//         return false
//     })
// }

// function filterUserRoutes(rotasPrivadas: IRotas, userRoutes: IUserRoutes[], locationPath: string) {
//     if (userRoutes === undefined || userRoutes.length === 0) {
//         return rotasPrivadas
//     }

//     // string das rotas filtradas pelo regex para ignorar os parâmetros
//     // ':idParam' que vem do rotasPrivadas, e o próprio id da rota (qualquer número)
//     const padrao = '[/a-z]+'
//     const currentPath = locationPath.match(padrao)![0] ?? ''

//     if (rotasPrivadas.children) {
//         return findAbsolutePath(rotasPrivadas.children, currentPath)
//     }

//     return false
// }

export function ControleRotasPrivadas() {
    const { logout } = useAuth()

    const location = useLocation()

    const navigate = useNavigate()

    useEffect(() => {
        const token = ServiceStorage.getToken()

      /*VALIDAR SE LOGIN ESTÁ VÁLIDO
        if (!token && location.pathname !== '/home') {
            logout()
            navigate('/')
        }
       */
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [location])

    // if (!autenticado) {
    //     // #AQUI
    //     window.localStorage.setItem('location', JSON.stringify(location.pathname))
    //     return <Navigate to='/' replace />
    // } else {
    //     if (!filterUserRoutes(RotasPrivadas, userRoutes, location.pathname)) {
    //         return <AccessDenied />
    //     }
    // }

    return <Outlet />
}
