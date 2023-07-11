import api, { getHeaders } from '../global'

export async function apiGetUf() {
    const { data } = await api.get(`/utils/uf`, getHeaders())
    return data
}

export async function apiGetUfListar(ufs: string[] = []) {
    const { data } = await api.post(`/utils/uf/listar`, { ufs }, getHeaders())
    return data
}

export async function apiGetMunicipio(uf: string) {
    const { data } = await api.get(`/utils/municipio/${uf}`, getHeaders())
    return data
}
