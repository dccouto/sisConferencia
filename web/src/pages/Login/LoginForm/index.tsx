import { useState } from 'react'
import { FormControl, Grid, Typography } from '@mui/material'
import { FormProvider, useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'

// Forms
import { FormContainer } from '../../../components/Formulario/FormContainer'
import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'

// Types
import { IUsuarioLogin } from '../LoginForm/loginTypes'

// Hooks
import { useToast } from '../../../hooks/useToast'
import { IUserRoutes, useAuth, UserAuth } from '../../../hooks/useAuth'

// Services
import { apiLogin, mockLogin } from '../../../services/auth'
import { useDrawer } from '../../../components/CidadaniaApp/Drawer/hooks/useDrawer'

import '../../../assets/styleLogin.css'
import { RHFMaskedInput } from '../../../components/Formulario/reactHookForms/RHFMaskedInput'
import { RHFText } from '../../../components/Formulario/reactHookForms/RHFText'
import ServiceStorage from '../../../services/storage'
import LoginFormGovBr from '../LoginFormGovBr'


const LoginForm = () => {
    const { isDesktop } = useDrawer()
    const { toastError } = useToast()
    const { login } = useAuth()

    // let versao = process.env.REACT_APP_VERSAO || '1.0.4'

    const { version: versao } = require('../../../../package.json')

    const [loading, setLoading] = useState(false)

    const imageSize = isDesktop ? 400 : 0

    const defaultValues = {
        nu_cpf_pessoa: '',
        ds_senha: '',
    }

    const schema = yup.object().shape({
        nu_cpf_pessoa: yup.string().required('Campo de preenchimento obrigatório *'),
        ds_senha: yup.string().required('Campo de preenchimento obrigatório *'),
    })

    const rhfmethods = useForm<IUsuarioLogin>({ defaultValues, resolver: yupResolver(schema) })

    function formatCPF(cpf: any) {
        const cpfRegex = /^(\d{3})(\d{3})(\d{3})(\d{2})$/
        return cpf.replace(cpfRegex, '$1.$2.$3-$4')
    }



    const loginMock = async () => {
        const newAuthMock = await mockLogin();
        login(newAuthMock);
    }

    
    const handleRealizarLogin = async (values: IUsuarioLogin) => {
        try {
            setLoading(true)

            const result:any = await apiLogin(values)

            if (!result) {
                toastError(result.message.retorno)
               
            } else {
               
                const newAuthData: UserAuth = {
                    autenticado: true,
                    name: result.nome,
                    cpf: formatCPF(result.cpf),
                    perfil: result?.perfil || '',
                    esfera: getEsfera(result?.codPerfil),
                    unidades: result?.unidades || [],
                    ibge: result?.ibge || '',
                    userMenuItems: result.permissoes,
                    userRoutes: [], //controle das rotas privadas
                }

                login(newAuthData)

                ServiceStorage.setToken(result.token)
            }
        } catch (error: any) {
            console.log(error)
            toastError(error?.error || 'Não foi possível fazer login')
        } finally {
            setLoading(false)
        }
    }

    function getEsfera(codPerfil: number) {
        const perfis = [
            { id: 1, code: 'Administrador_RedeSUAS', esfera: undefined },
            { id: 2, code: 'Gestor_Federal', esfera: 'Federal' },
            { id: 3, code: 'Gestor_Estadual', esfera: 'Estadual' },
            { id: 4, code: 'Gestor_Municipal', esfera: 'Municipal' },
            { id: 5, code: 'Técnico_Estadual', esfera: 'Estadual' },
            { id: 6, code: 'Técnico_Municipal', esfera: 'Municipal' },
            { id: 7, code: 'Conselheiro_Estadual', esfera: 'Estadual' },
            { id: 8, code: 'Conselheiro_Municipal', esfera: 'Municipal' },
            { id: 9, code: 'Consulta', esfera: undefined },
        ]

        const perfil = perfis.find((p) => p.id === codPerfil)

        return perfil ? perfil.esfera : undefined
    }

    const botaoGovBr =    <LoginFormGovBr></LoginFormGovBr>
    
    return (
        <Grid >
           
            
            <Grid item xs={isDesktop ? 7 : 12} paddingTop={2}>

                
            </Grid>
            <Grid alignItems={'center'} >
                        <img
                            src='/logo.png'
                            style={{ width: imageSize, height: imageSize }}
                            alt='Minha Rede Suas'
                            className={'titulo'}
                        />
                         <FormContainer onSubmitHandler={loginMock}>

                            <BotaoPadrao
                                loading={loading}
                                size='large'
                                type={'submit'}
                                style={{ width: '100%', borderRadius: 5 }}
                            >
                                Acessar
                            </BotaoPadrao>
                        </FormContainer>
                        <Typography fontWeight={'bold'} marginTop={1} fontSize={15}>
                           SIS CONFERÊNCIA
                        </Typography>
                        <Typography fontSize={12}>Versão {versao}</Typography>
                    </Grid>
            {botaoGovBr} 
        </Grid>
    )
}

export { LoginForm }
