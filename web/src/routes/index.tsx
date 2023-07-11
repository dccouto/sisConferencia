import { RouteObject, useRoutes } from 'react-router-dom'
import { Suspense } from 'react'
import { LoadingPage } from '../components/Auth/LoadingPage'
import { RotasPrivadas } from './RotasPrivadas'
import { RotasPublicas } from './RotasPublicas'
import { PageNotFound } from '../components/Auth/PageNotFound'

const rotas404: RouteObject = {
    path: '*',
    element: <PageNotFound />,
}

export function AppRoutes() {
    const rotas = useRoutes([RotasPrivadas, RotasPublicas, rotas404])

    return <Suspense fallback={<LoadingPage />}>{rotas}</Suspense>
}

// ok, aparentemente, deixar as rotas serem carregadas depois do login não é uma boa,
// acho que elas foram feitas pra ficarem fixas mesmo
// e colocar um controle de redirecionamento por perfil
