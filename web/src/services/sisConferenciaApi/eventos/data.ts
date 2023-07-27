export interface IEventoResultTable {
    id: number;
    nome: string;
    objetivo: string;
    tema: string;
    dataInicial: Date | null;
    dataFinal: Date | null;
    ativo: boolean | null;
    tipoEvento: ITipoEvento;
    tipoFormato: ITipoFormato;
}

export interface ITipoEvento {
    descricao: string;
    id: number;
  }
  
  export interface ITipoFormato {
    descricao: string;
    id: number;
  }


export type IListaEventosTable = IEventoResultTable[];