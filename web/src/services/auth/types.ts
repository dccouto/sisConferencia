
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
