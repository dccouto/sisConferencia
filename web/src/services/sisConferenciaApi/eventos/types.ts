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
  
  export interface IFormato {
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
    tipoRegime: IFormato
  }

  export interface IEventoSalvar {
    dataCadastro: string;
    dataFinal: string;
    dataInicial: string;
    objetivo: string;
    nome: string;
    portaria: number;
    tema: string;
    tipoEvento: number;
    formato: number;
  }
  
  // Para a lista de eventos
  export type IListaEventos = IEvento[];