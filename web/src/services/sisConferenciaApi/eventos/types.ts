export interface IEmenta {
    descricao: string;
    id: number;
}


export interface IEixoResult {
    descricao: string;
    ementa: IEmenta;
    id: IidEventoEixo;
    numero: number;
    tema: string;
  }

  export interface IDocumento {
    id: number;
    dataEnvio: Date; 
    extensao: string;
    
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
    documento:any
  }
  
  export interface ITipoEvento {
    descricao: string;
    id: number;
  }
  
  export interface ITipoFormato {
    descricao: string;
    id: number;
  }


    
  export interface IidEventoEixo {
    eixoId: number;
    eventoId: number;
  }
  
  export interface IEvento {
    dataCadastro: string;
    dataFinal: string;
    dataInicial: string;
    objetivo: string;
    nome: string;
    eixos: IEixoResult[];
    id: number;
    portaria: IPortaria;
    tema: string;
    tipoEvento: ITipoEvento;
    tipoRegime: ITipoFormato;
  }

  export interface IEventoSalvar {
    id:number,
    dataCadastro: string;
    dataFinal: string;
    dataInicial: string;
    objetivo: string | '';
    nome: string;
    portaria: number;
    eixos: IEixo[];
    tema: string;
    tipoEvento: number;
    tipoFormato: number;
    imagem: Arquivo;
  }
  

  export interface Arquivo {  
    id: number;
    nome: string;
    byteArquivo: string | null;  // Array de bytes
  }
  // Para a lista de eventos
  export type IListaEventos = IEvento[];