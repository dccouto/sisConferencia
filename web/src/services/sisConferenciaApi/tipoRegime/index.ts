
import api, { getHeaders } from '../../global'
import { ITipoRegime } from './types';




const apiServiceTipoRegime = {
    listar: async () => {
        try {
            const response = await api.get<ITipoRegime[]>('/tipoRegime');
            return response;
        } catch (error) {
            console.error(error);
            return [];
        }
    },
    criar: async function (data: ITipoRegime): Promise<any>  {
        try {
            
            const response = await api.post<ITipoRegime>('/tipoRegime', data, getHeaders());
            return response;
        } catch (error) {
            console.error('Erro ao obter o tipo de regime:', error);
            throw error;
        }
    },
    atualizar: async (id: number, data: ITipoRegime):Promise<any>  => {
        try {
            const response = await api.put(`/tipoRegime/${id}`, data, getHeaders());
            return response;
        } catch (error) {
            console.error(error);
        }
    },

    excluir: async (id: number): Promise<void> => {
        try {
            await api.delete(`/tipoRegime/${id}`);
        } catch (error) {
            console.error(error);
        }
    }
};

export default apiServiceTipoRegime;