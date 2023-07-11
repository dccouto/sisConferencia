export enum EStatusRequerimento {
    RASCUNHO = 'R',
    PUBLICADO = 'P',
    TODOS = 'RP',
}

export interface IEventos {
    ID: number
    DESCRICAO: string
    PERIODO:number
    TIPO_EVENTO:ITipoEvento
    PORTARIA:string
    TEMA:string
    ID_TIPO_REGIME:ITipoRegime
    DATA_INICIAL:Date
    DATA_FINAL:Date
}


export interface ITipoEvento {
    ID: number
    DESCRICAO: string
}

export interface ITipoRegime {
    ID: number
    DESCRICAO: string
}