import api, { getHeaders } from '../global'

// Types
import { IUsuarioLogin } from './types'
import { IMenuItem } from '../../types'
import { IUserRoutes, UserAuth } from '../../hooks/useAuth'

export const apiLogin = async (data: IUsuarioLogin) => {
    const headers = getHeaders()
    const url = `/auth/login`
    return api.post(url, data, headers)
}


export async function mockLogin(): Promise<UserAuth> {
    const menuObjeto: IMenuItem [] = [{
      id: "1",
      menu: "Eventos",
      rota: "/",
      funcionalidades: [1, 2, 3],
      submenu: [
        {
          id: "1.1",
          menu: "Conferências ",
          rota: "/eventos/conferencias",
          funcionalidades: [1, 2],
        },
        {
          id: "1.2",
          menu: "Reuniões",
          rota: "/eventos/reunioes",
          funcionalidades: [2, 3],
        },
      ],
    },{
        id: "2",
        menu: "Cadastro de Conselheiros",
        rota: "/",
        funcionalidades: [1, 2, 3],
        submenu: [
          {
            id: "1.1",
            menu: "Delegados ",
            rota: "/delegados",
            funcionalidades: [1, 2],
          },
          {
            id: "1.2",
            menu: "Conselheiros",
            rota: "/conselheiros",
            funcionalidades: [2, 3],
          },
          {
            id: "1.3",
            menu: "Observadores",
            rota: "/observadores",
            funcionalidades: [2, 3],
          },
          {
            id: "1.4",
            menu: "Ouvintes",
            rota: "/ouvintes",
            funcionalidades: [2, 3],
          },
          {
            id: "1.5",
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
            id: "1.1",
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
            id: "1.1",
            menu: "Documentos",
            rota: "/documentos",
            funcionalidades: [1, 2],
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
