
import { AxiosResponse } from 'axios';
import api, { getHeaders, getHeadersFiles } from '../../global'
import { IEvento } from './types';
import { IListaEventos } from './types';



const apiServiceEventos = {
    listar: async () => {
        try {
            const response = await api.get<IListaEventos[]>('/eventos');
            return response;
        } catch (error) {
            console.error(error);
            return [];
        }
    },
    criar: async function (data: IEvento): Promise<any>  {
        try {
            
            const response = await api.post<IEvento>('/eventos', data, getHeaders());
            return response;
        } catch (error) {
            console.error('Erro ao obter o tipo de evento:', error);
            throw error;
        }
    },
    atualizar: async (id: number, data: IEvento):Promise<any>  => {
        try {
            const response = await api.put(`/eventos/${id}`, data, getHeaders());
            return response;
        } catch (error) {
            console.error(error);
        }
    },

    excluir: async (id: number): Promise<void> => {
        try {
            await api.delete(`/eventos/${id}`);
        } catch (error) {
            console.error(error);
        }
    }
};

export default apiServiceEventos;