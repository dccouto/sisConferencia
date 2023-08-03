import { lazy } from 'react'
import { RouteObject } from 'react-router-dom'

import { ControleRotasPrivadas } from '../components/Auth/ControleRotasPrivadas'
import { privateRoutesNames } from './routesConstants'


let Home = lazy(() => import('../pages/Home'))

//Conferencias e Reunioes(Eventos)
let EventosConferenciaReunioes = lazy(() => import('../pages/Eventos'))


// Administrador
let Perfil = lazy(() => import('../pages/Administrador/Perfil'))
let TipoFormato = lazy(() => import('../pages/Administrador/TipoFormato'))
let Portaria = lazy(() => import('../pages/Administrador/Portaria'))
let TipoEvento = lazy(() => import('../pages/Administrador/TipoEvento'))
let Eventos = lazy(() => import('../pages/Administrador/Eventos'))
let RegistrarEvento = lazy(() => import('../pages/Administrador/Eventos/Registrar'))
let GovBrContext = lazy(() => import('../services/GovBrContext'))


export interface IRotas extends RouteObject {
    name: string
    children?: IRotas[]
}

export const RotasPrivadas: IRotas = {
    name: '',
    element: <ControleRotasPrivadas />,
    children: [
        {
            name: privateRoutesNames.home.name,
            path: privateRoutesNames.home.path,
            element: <Home />,
        },
         //gov.br
       {    
        name:'govBr',
        path:'/sso/code/',
        element:<GovBrContext/>,
       },


       //ConferenciaReunioes
       {    
            name:'conferenciaReunioes',
            path:'/eventos',
            element:<EventosConferenciaReunioes/>,
       },


        // Administradores
        {
            name: 'administracao',
            path: '/administracao',
            element: <Perfil />,
        },
        {
            name: privateRoutesNames.adminPerfil.name,
            path: privateRoutesNames.adminPerfil.path,
            element: <Perfil />,
        },
        {
            name: privateRoutesNames.adminTipoEvento.name,
            path: privateRoutesNames.adminTipoEvento.path,
            element: <TipoEvento/>,
        },
        {
            name: privateRoutesNames.adminTipoFormato.name,
            path: privateRoutesNames.adminTipoFormato.path,
            element: <TipoFormato/>,
        },
        {
            name: privateRoutesNames.adminPortaria.name,
            path: privateRoutesNames.adminPortaria.path,
            element: <Portaria/>,
        },
        {
            name: privateRoutesNames.adminEventos.name,
            path: privateRoutesNames.adminEventos.path,
            element: <Eventos/>,
        },
        //Administrar Eventos
        {
            name: privateRoutesNames.adminEventosCriar.name,
            path: privateRoutesNames.adminEventosCriar.path,
            element: <RegistrarEvento/>,
        },
        {
            name: privateRoutesNames.adminEventosAlterar.name,
            path: privateRoutesNames.adminEventosAlterar.path,
            element: <RegistrarEvento/>,
        },

 
    ],
}
