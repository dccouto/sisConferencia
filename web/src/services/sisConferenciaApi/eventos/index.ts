
import { AxiosResponse } from 'axios';
import api, { getHeaders, getHeadersFiles } from '../../global'
import { IEvento, IEventoSalvar } from './types';
import { IListaEventos } from './types';





const apiServiceEventos = {
    listar: async () => {
        try {
            const response = await api.get<IEvento[]>('/eventos');
            return response;
        } catch (error) {
            console.error(error);
            return [];
        }
    },
    criar: async function (data: IEventoSalvar): Promise<any>  {
        try {
            
            const response = await api.post<IEventoSalvar>('/eventos', data, getHeaders());
            return response;
        } catch (error) {
            console.error('Erro ao criar evento:', error);
            throw error;
        }
    },
    atualizar: async (id: number, data: IEventoSalvar):Promise<any>  => {
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