
import api, { getHeaders } from '../../global'
import {  IFormato } from './types';




const apiServiceFormato = {
    listar: async () => {
        try {
            const response = await api.get<IFormato[]>('/formato');
            return response;
        } catch (error) {
            console.error(error);
            return [];
        }
    },
    criar: async function (data: IFormato): Promise<any>  {
        try {
            
            const response = await api.post<IFormato>('/formato', data, getHeaders());
            return response;
        } catch (error) {
            console.error('Erro ao obter formato:', error);
            throw error;
        }
    },
    atualizar: async (id: number, data: IFormato):Promise<any>  => {
        try {
            const response = await api.put(`/formato/${id}`, data, getHeaders());
            return response;
        } catch (error) {
            console.error(error);
        }
    },

    excluir: async (id: number): Promise<void> => {
        try {
            await api.delete(`/formato/${id}`);
        } catch (error) {
            console.error(error);
        }
    }
};

export default apiServiceFormato;