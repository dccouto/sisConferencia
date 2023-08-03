
export enum EStatusEvent {
    RASCUNHO = 'R',
    PUBLICADO = 'P',
    TODOS = 'RP',
}

export type EventBodyList = {
    page: number
    limit: number
}

export interface IUsuarioLogin {
    nu_cpf_pessoa: string;
    ds_senha: string;
}


export interface IUsuarioGovBr {
    autenticado: boolean;
    govbr: boolean;
    telefone: string;
    auth: string;
    cpf: string;
    nome: string;
    id: string;
    login: string;
    email: string;
    exp: number;
    iat: number;
}



export interface ITokenSso {
    token: string;
    servicoCacheDTO: any | null;
}
