import { lazy } from 'react'
import { RouteObject } from 'react-router-dom'

import { ControleRotasPrivadas } from '../components/Auth/ControleRotasPrivadas'
import { privateRoutesNames } from './routesConstants'


let Home = lazy(() => import('../pages/Home'))
let Conferencias = lazy(() => import('../pages/Eventos/Conferencias'))
let Reunioes = lazy(() => import('../pages/Eventos/Reunioes'))



// Administrador
let Perfil = lazy(() => import('../pages/Administrador/Perfil'))
let TipoEvento = lazy(() => import('../pages/Administrador/TipoEvento'))
let Eventos = lazy(() => import('../pages/Administrador/Eventos'))
let CriarEvento = lazy(() => import('../pages/Administrador/Eventos/Criar'))


// Eventos Conferencia
let ConferenciasListar = lazy(() =>  import('../pages/Eventos/Conferencias/Listar'))
let ConferenciasRegistrar = lazy(() => import('../pages/Eventos/Conferencias/Registrar'))
// Eventos Reunioes
let ReunioesListar = lazy(() =>  import('../pages/Eventos/Reunioes/Listar'))
let ReunioesRegistrar = lazy(() => import('../pages/Eventos/Reunioes/Registrar'))





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

      
        // Gestão de Eventos Conferencia
        {
            name: privateRoutesNames.eventosConferencias.name,
            path: privateRoutesNames.eventosConferencias.path,
            element: <Conferencias />,
        },
       
        {
            name: privateRoutesNames.eventosConferenciasRegistrar.name,
            path: privateRoutesNames.eventosConferenciasRegistrar.path,
            element: <ConferenciasRegistrar />,
        },
        {
            name: privateRoutesNames.eventosConferenciasAtualizar.name,
            path: privateRoutesNames.eventosConferenciasAtualizar.path,
            element: <ConferenciasRegistrar />,
        },
     
        {
            name: privateRoutesNames.eventosConferenciasListar.name,
            path: privateRoutesNames.eventosConferenciasListar.path,
            element: <ConferenciasListar />,
        },


          // Gestão de Eventos Reunioes
          {
            name: privateRoutesNames.eventosReunioes.name,
            path: privateRoutesNames.eventosReunioes.path,
            element: <Reunioes />,
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
            name: privateRoutesNames.adminEventos.name,
            path: privateRoutesNames.adminEventos.path,
            element: <Eventos/>,
        },
        //Administrar Eventos
        {
            name: privateRoutesNames.adminEventosCriar.name,
            path: privateRoutesNames.adminEventosCriar.path,
            element: <CriarEvento/>,
        },
        {
            name: privateRoutesNames.eventosReunioesAtualizar.name,
            path: privateRoutesNames.eventosReunioesAtualizar.path,
            element: <ReunioesRegistrar />,
        },

        {
            name: privateRoutesNames.eventosReunioesListar.name,
            path: privateRoutesNames.eventosReunioesListar.path,
            element: <ReunioesListar />,
        },
    ],
}
