import api, { getHeaders } from '../global'

// Types
import {
    IEventos,
} from './types'

export const apiEventosListarPorAno = async (ano: number) => {
    return api.get<IEventos[]>(`/eventos/listar/${ano}`, getHeaders())
}

export const apiEventosListarPorEsfere = async (tpEsfera: number) => {
    return api.get<IEventos>(`/eventos/show/${tpEsfera}`, getHeaders())
}

export const apiEventosListar = async (data: IEventos) => {
    return api.post<IEventos[]>(`/requerimento/rp2/listar`, data, getHeaders())
}


export const apiEventosListarBuscar = async (id: number) => {
    return api.get<IEventos>(`/requerimento/rp2/resultado/${id}`, getHeaders())
}

