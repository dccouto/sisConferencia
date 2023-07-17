export interface IRoutesNames {
    [key: string]: {
        name: string
        path: string
    }
}

export const privateRoutesNames: IRoutesNames = {
    home: {
        name: 'home',
        path: '/home',
    },

    // Eventos 
    eventos: {
        name: 'eventos',
        path: '/eventos/',
    },
    // Eventos Conferencia
    eventosConferencias: {
        name: 'conferencias',
        path: '/eventos/conferencias',
    },
    eventosConferenciasListar: {
        name: 'conferenciasListar',
        path: '/eventos/conferencias/listar',
    },
    eventosConferenciasVisualizar: {
        name: 'conferenciasVisualizar',
        path: '/eventos/conferencias/visualizar/:id',
    },
    eventosConferenciasAtualizar: {
        name: 'conferenciasAtualizar',
        path: '/eventos/conferencias/registrar/:id',
    },
    eventosConferenciasRegistrar: {
        name: 'conferenciasRegistrar',
        path: '/eventos/conferencias/registrar',
    },

    // Eventos Reunioes
    eventosReunioes: {
        name: 'reunioes',
        path: '/eventos/reunioes',
    },
    eventosReunioesListar: {
        name: 'reunioesListar',
        path: '/eventos/reunioes/listar',
    },
    eventosReunioesVisualizar: {
        name: 'reunioesVisualizar',
        path: '/eventos/reunioes/visualizar/:id',
    },
    eventosReunioesAtualizar: {
        name: 'reunioesAtualizar',
        path: '/eventos/reunioes/registrar/:id',
    },
    eventosReunioesRegistrar: {
        name: 'reunioesRegistrar',
        path: '/eventos/reunioes/registrar',
    },


   

    // Administrator
    admin: {
        name: 'administrador',
        path: '/administracao',
    },
    adminPerfil: {
        name: 'adminPerfil',
        path: '/administracao/perfil',
    },
    adminTipoEvento: {
        name: 'adminTipoEvento',
        path: '/administracao/TipoEvento',
    },
}

export const publicRoutesNames: IRoutesNames = {
    index: {
        name: 'index',
        path: '/',
    },
    autenticando: {
        name: 'autenticando',
        path: '/autenticando',
    },
}
