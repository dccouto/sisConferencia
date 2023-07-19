export interface IEmenta {
    descricao: string;
    id: number;
  }
  
  export interface IEixo {
    descricao: string;
    ementa: IEmenta;
    id: number;
    numero: number;
    tema: string;
  }
  
  export interface IPortaria {
    dataPortaria: string;
    descricao: string;
    id: number;
    numero: string;
  }
  
  export interface ITipoEvento {
    descricao: string;
    id: number;
  }
  
  export interface ITipoRegime {
    descricao: string;
    id: number;
  }
  
  export interface IEvento {
    dataCadastro: string;
    dataFinal: string;
    dataInicial: string;
    objetivo: string;
    nome: string;
    eixos: IEixo[];
    id: number;
    portaria: IPortaria;
    tema: string;
    tipoEvento: ITipoEvento;
    tipoRegime: ITipoRegime;
  }
  
  // Para a lista de eventos
  export type IListaEventos = IEvento[];