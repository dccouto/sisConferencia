import { api } from "../services/api";

interface ISalvarProps {
  url: string;
  dados: any;
  id?: number | string;
}

export async function recuperar(url: string, signal?: any) {
  const { data } = await api.get(url, { signal });
  return data;
}

export async function salvar({ url, dados, id }: ISalvarProps) {
  if (id) {
    return await api.put(`${url}/${id}`, { ...dados });
  }

  return await api.post(url, { ...dados });
}

export async function deletar(url: string) {
  return api.delete(url);
}

export async function pesquisar(url: string, dados: any) {
  const params = new URLSearchParams(dados).toString();
  return recuperar(url + "?" + params);
}
