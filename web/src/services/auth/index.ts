import api, { getHeaders } from '../global'

// Types
import { ITokenSso, IUsuarioGovBr, IUsuarioLogin } from './types'
import { IMenuItem } from '../../types'
import { IUserRoutes, UserAuth } from '../../hooks/useAuth'
import { govBrConstants } from '../../utils/constants'
import { formatCPF } from '../../utils'

export const apiLogin = async (data: IUsuarioLogin) => {
    const headers = getHeaders()
    const url = `/auth/login`
    return api.post(url, data, headers)
}


export const obterTokenSso = async (code: string | ''): Promise<any> => {
  const url = `${govBrConstants.urlObterToken}` + code + '/cab'
  const response = await api.get<ITokenSso>(url);
  
  if (!response.token ) {
    throw new Error('Resposta inválida do servidor');
  }

  return response;
}


export async function loginGovBr(usuarioGov : IUsuarioGovBr): Promise<UserAuth> {

  const menuObjeto: IMenuItem [] = [{
    id: "1",
    menu: "Eventos",
    rota: "/eventos",
    funcionalidades: [1, 2, 3],
    submenu: [
      {
        id: "1.1",
        menu: "Conferências e Reuniões ",
        rota: "/eventos",
        funcionalidades: [1, 2],
      },
    ]
  },{
      id: "2",
      menu: "Cadastro de Participantes",
      rota: "/",
      funcionalidades: [1, 2, 3],
      submenu: [
        {
          id: "2.1",
          menu: "Delegados ",
          rota: "/delegados",
          funcionalidades: [1, 2],
        },
        {
          id: "2.2",
          menu: "Conselheiros",
          rota: "/conselheiros",
          funcionalidades: [2, 3],
        },
        {
          id: "2.3",
          menu: "Observadores",
          rota: "/observadores",
          funcionalidades: [2, 3],
        },
        {
          id: "2.4",
          menu: "Ouvintes",
          rota: "/ouvintes",
          funcionalidades: [2, 3],
        },
        {
          id: "2.5",
          menu: "Palestrantes",
          rota: "/palestrantes",
          funcionalidades: [2, 3],
        },
      ],
    },{
      id: "3",
      menu: "Eleição Sociedade Civil",
      rota: "/",
      funcionalidades: [1, 2, 3],
      submenu: [
        {
          id: "3.1",
          menu: "Relatório de eleição de conselheiros",
          rota: "/relatorio",
          funcionalidades: [1, 2],
        },
      ],
    },{
      id: "4",
      menu: "Biblioteca",
      rota: "/",
      funcionalidades: [1, 2, 3],
      submenu: [
        {
          id: "4.1",
          menu: "Documentos",
          rota: "/documentos",
          funcionalidades: [1, 2],
        },
      ],
    },{
      id: "5",
      menu: "Administrador",
      rota: "/",
      funcionalidades: [1, 2, 3],
      submenu: [
        {
          id: "5.1",
          menu: "Tipo de Eventos",
          rota: "/administracao/TipoEvento",
          funcionalidades: [1, 2,3],
        },
        {
          id: "5.2",
          menu: "Eventos",
          rota: "/administracao/Eventos",
          funcionalidades: [1, 2,3],
        },
        {
          id: "5.3",
          menu: "Formato de Evento",
          rota: "/administracao/TipoFormato",
          funcionalidades: [1, 2,3],
        },
        {
          id: "5.4",
          menu: "Portaria",
          rota: "/administracao/Portaria",
          funcionalidades: [1, 2,3],
        },
      ],
    }];
  const userRoutes: IUserRoutes = {
    name: "User Routes",
    permissions: ['cadastrar', 'editar', 'listar','excluir'],
  };



  
  const userAuthDefaultValues: UserAuth = {
    name: usuarioGov.nome,
    cpf: formatCPF(usuarioGov.cpf),
    perfil: 'Admin',
    esfera: 'Nacional',
    autenticado: true,
    unidades: ['CONSELHO NACIONAL'],
    ibge: undefined,
    userRoutes: [userRoutes],
    userMenuItems: menuObjeto,
  };


  console.log(userAuthDefaultValues);
  return new Promise<UserAuth>((resolve) => {
    resolve(userAuthDefaultValues);
  });
}


export async function mockLogin(): Promise<UserAuth> {
    const menuObjeto: IMenuItem [] = [{
      id: "1",
      menu: "Eventos",
      rota: "/eventos",
      funcionalidades: [1, 2, 3],
      submenu: [
        {
          id: "1.1",
          menu: "Conferências e Reuniões ",
          rota: "/eventos",
          funcionalidades: [1, 2],
        },
      ]
    },{
        id: "2",
        menu: "Cadastro de Participantes",
        rota: "/",
        funcionalidades: [1, 2, 3],
        submenu: [
          {
            id: "2.1",
            menu: "Delegados ",
            rota: "/delegados",
            funcionalidades: [1, 2],
          },
          {
            id: "2.2",
            menu: "Conselheiros",
            rota: "/conselheiros",
            funcionalidades: [2, 3],
          },
          {
            id: "2.3",
            menu: "Observadores",
            rota: "/observadores",
            funcionalidades: [2, 3],
          },
          {
            id: "2.4",
            menu: "Ouvintes",
            rota: "/ouvintes",
            funcionalidades: [2, 3],
          },
          {
            id: "2.5",
            menu: "Palestrantes",
            rota: "/palestrantes",
            funcionalidades: [2, 3],
          },
        ],
      },{
        id: "3",
        menu: "Eleição Sociedade Civil",
        rota: "/",
        funcionalidades: [1, 2, 3],
        submenu: [
          {
            id: "3.1",
            menu: "Relatório de eleição de conselheiros",
            rota: "/relatorio",
            funcionalidades: [1, 2],
          },
        ],
      },{
        id: "4",
        menu: "Biblioteca",
        rota: "/",
        funcionalidades: [1, 2, 3],
        submenu: [
          {
            id: "4.1",
            menu: "Documentos",
            rota: "/documentos",
            funcionalidades: [1, 2],
          },
        ],
      },{
        id: "5",
        menu: "Administrador",
        rota: "/",
        funcionalidades: [1, 2, 3],
        submenu: [
          {
            id: "5.1",
            menu: "Tipo de Eventos",
            rota: "/administracao/TipoEvento",
            funcionalidades: [1, 2,3],
          },
          {
            id: "5.2",
            menu: "Eventos",
            rota: "/administracao/Eventos",
            funcionalidades: [1, 2,3],
          },
          {
            id: "5.3",
            menu: "Formato de Evento",
            rota: "/administracao/TipoFormato",
            funcionalidades: [1, 2,3],
          },
          {
            id: "5.4",
            menu: "Portaria",
            rota: "/administracao/Portaria",
            funcionalidades: [1, 2,3],
          },
        ],
      }];
    const userRoutes: IUserRoutes = {
      name: "User Routes",
      permissions: ['cadastrar', 'editar', 'listar','excluir'],
    };
  



    const userAuthDefaultValues: UserAuth = {
      name: 'Marco Antonio',
      cpf: '023.652.961.73',
      perfil: 'Admin',
      esfera: 'Nacional',
      autenticado: true,
      unidades: ['CONSELHO NACIONAL'],
      ibge: undefined,
      userRoutes: [userRoutes],
      userMenuItems: menuObjeto,
    };
  
    return new Promise<UserAuth>((resolve) => {
      resolve(userAuthDefaultValues);
    });
  }
