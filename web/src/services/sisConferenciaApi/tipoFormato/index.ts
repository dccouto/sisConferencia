
import api, { getHeaders } from '../../global'
import {  ITipoFormato } from './types';




const apiServiceTipoFormato = {
    listar: async () => {
        try {
            const response = await api.get<ITipoFormato[]>('/tipoFormato');
            return response;
        } catch (error) {
            console.error(error);
            return [];
        }
    },
    criar: async function (data: ITipoFormato): Promise<any>  {
        try {
            
            const response = await api.post<ITipoFormato>('/tipoFormato', data, getHeaders());
            return response;
        } catch (error) {
            console.error('Erro ao obter tipoFormato:', error);
            throw error;
        }
    },
    atualizar: async (id: number, data: ITipoFormato):Promise<any>  => {
        try {
            const response = await api.put(`/tipoFormato/${id}`, data, getHeaders());
            return response;
        } catch (error) {
            console.error(error);
        }
    },

    excluir: async (id: number): Promise<void> => {
        try {
            await api.delete(`/tipoFormato/${id}`);
        } catch (error) {
            console.error(error);
        }
    }
};

export default apiServiceTipoFormato;