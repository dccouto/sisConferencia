// Components

import jsonServerProvider from 'ra-data-json-server';


// Services

import { useEffect, useState } from 'react';
import apiServiceEventos from '../../services/sisConferenciaApi/eventos';
import { Titulo } from '../../components/Navegacao/Titulo';
import { Breadcrumbs } from '../../components/Navegacao/Breadcrumbs';
import { IListaEventos } from '../../services/sisConferenciaApi/eventos/types';




const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig= [
    { key: 'id', displayName: 'ID', width: 300, visible: true },
    { key: 'descricao', displayName: 'Descrição', visible: true },
    { key: 'dataCadastro', displayName: 'Data Cadastro', visible: true },
    { key: 'dataFinal', displayName: 'Data Final', visible: true },
    { key: 'dataInicial', displayName: 'Data Inicial', visible: true },
    { key: 'portaria', displayName: 'Portaria', visible: true },
    { key: 'tema', displayName: 'Tema', visible: true },
    { key: 'tipoEvento', displayName: 'Tipo de Evento', visible: true },
    { key: 'tipoRegime', displayName: 'Tipo de Regime', visible: true },
];



export default function Eventos_conferencia_reunioes() {

    const [Eventos,setEventos] = useState<IListaEventos>([])


    useEffect(() => {
        

        async function buscarListaEventos() {
            try {
                const result = await apiServiceEventos.listar();
                if (Array.isArray(result)) {
                    setEventos(result);
                } else {
                    console.error("Result is not an array");
                }
            } catch (error) {
                console.error(error);
            }
        }

        buscarListaEventos();
    }, [])
    
    return (
        <>
            <Breadcrumbs
                current={`Conferências e reuniões`}
                prevCrumbs={[{ name: 'Eventos' }]}
            />
            <Titulo titulo={`Eventos`} voltar={paginaInicial} />

           
        </>
    )
}