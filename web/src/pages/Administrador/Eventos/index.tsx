// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import jsonServerProvider from 'ra-data-json-server';


// Services

import { useEffect, useState } from 'react';
import { IListaEventos } from '../../../services/sisConferenciaApi/eventos/types';
import EventoCrud from './EventoCrud';
import apiServiceEventos from '../../../services/sisConferenciaApi/eventos';
import { LoadingPage } from '../../../components/Auth/LoadingPage';




const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig= [
    { key: 'id', displayName: 'ID', width: 300, visible: true },
    { key: 'nome', displayName: 'Nome', width: 300, visible: true },
    { key: 'objetivo', displayName: 'Objetivo', visible: true },
    { key: 'dataFinal', displayName: 'Data Final', visible: true },
    { key: 'dataInicial', displayName: 'Data Inicial', visible: true },
    { key: 'tema', displayName: 'Tema', visible: true },
    { key: 'ativo', displayName: 'Ativo', visible: true },
    { key: 'tipoEvento', displayName: 'Tipo de Evento', visible: true },
    { key: 'tipoFormato', displayName: 'Formato do Evento', visible: true },
];



export default function Eventos() {     

    const [Eventos,setEventos] = useState<IListaEventos>([])
    const [exibirTabela,setExibirTabela] = useState(false)

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
                setExibirTabela(true);
                console.error(error);
                
            }
            setExibirTabela(true);
        }

        buscarListaEventos();
    }, [])
    
    return (
        <>
            {exibirTabela ? (
                <>
                    <Breadcrumbs
                        current={`Eventos`}
                        prevCrumbs={[{ name: 'Administração' }]}
                    />
                    <Titulo titulo={`Eventos`} voltar={paginaInicial} />

                    <EventoCrud visible={true} eventos={Eventos} setEventos={setEventos} apiService={apiServiceEventos} columnConfig={columnsConfig} />
                </>
            ) : (
                <LoadingPage />
            )}
        </>
    )
}