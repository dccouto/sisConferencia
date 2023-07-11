import { lazy } from 'react'
import { LoginForm } from '../pages/Login/LoginForm'
import { ControleRotasPublicas } from '../components/Auth/ControleRotasPublicas'
import { IRotas } from './RotasPrivadas'

const LoginContainer = lazy(() => import('../pages/Login/LoginContainer'))

const LoginProcess = lazy(() => import('../pages/Login/LoginProcess'))

export const RotasPublicas: IRotas = {
    name: '',
    element: <ControleRotasPublicas />,
    children: [
        {
            name: '',
            element: <LoginContainer />,
            children: [
                {
                    name: 'index',
                    index: true,
                    path: '/',
                    element: <LoginForm />,
                },
                {
                    name: 'autenticando',
                    path: '/autenticando',
                    element: <LoginProcess />,
                },
            ],
        },
    ],
}
