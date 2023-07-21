// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import jsonServerProvider from 'ra-data-json-server';
import TipoFormatoCrud from './TipoFormatoCrud';


// Services

import { useEffect, useState } from 'react';
import apiServiceTipoFormato from '../../../services/sisConferenciaApi/tipoFormato';
import { ITipoFormato } from '../../../services/sisConferenciaApi/tipoFormato/types';




const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig = [
    { key: 'id', displayName: 'ID', width: 300 ,visible:true},
    { key: 'descricao', displayName: 'Descrição',visible:true},
]



export default function TipoFormato() {

    const [tipoFormatos,setTipoFormatos] = useState<ITipoFormato[]>([])


    useEffect(() => {
        

        async function buscarListaTipoFormato() {
            try {
                const result = await apiServiceTipoFormato.listar();
                if (Array.isArray(result)) {
                    setTipoFormatos(result);
                } else {
                    console.error("Result is not an array");
                }
            } catch (error) {
                console.error(error);
            }
        }

        buscarListaTipoFormato();
    }, [])
    
    return (
        <>
            <Breadcrumbs
                current={`Formato de Evento`}
                prevCrumbs={[{ name: 'Administração' }]}
            />  
            <Titulo titulo={`Formato de Evento`} voltar={paginaInicial} />

            <TipoFormatoCrud visible={true} tipoFormatos={tipoFormatos} setTipoFormatos={setTipoFormatos} apiService={apiServiceTipoFormato} columnConfig={columnsConfig}></TipoFormatoCrud>
        </>
    )
}

