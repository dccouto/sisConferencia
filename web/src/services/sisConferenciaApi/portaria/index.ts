
import api, { getHeaders } from '../../global'
import {  IPortaria } from './types';




const apiServicePortaria = {
    listar: async () => {
        try {
            const response = await api.get<IPortaria[]>('/portaria');
            return response;
        } catch (error) {
            console.error(error);
            return [];
        }
    },
    criar: async function (data: IPortaria): Promise<any>  {
        try {
            
            const response = await api.post<IPortaria>('/portaria', data, getHeaders());
            return response;
        } catch (error) {
            console.error('Erro ao obter portaria:', error);
            throw error;
        }
    },
    atualizar: async (id: number, data: IPortaria):Promise<any>  => {
        try {
            const response = await api.put(`/portaria/${id}`, data, getHeaders());
            return response;
        } catch (error) {
            console.error(error);
        }
    },

    excluir: async (id: number): Promise<void> => {
        try {
            await api.delete(`/portaria/${id}`);
        } catch (error) {
            console.error(error);
        }
    }
};

export default apiServicePortaria;