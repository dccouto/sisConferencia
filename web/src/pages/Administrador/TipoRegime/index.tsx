// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import jsonServerProvider from 'ra-data-json-server';
import TipoRegimeCrud from './TipoRegimeCrud';


// Services
import apiServiceTipoRegime from './../../../services/sisConferenciaApi/tipoRegime/index';
import { useEffect, useState } from 'react';
import { ITipoRegime } from './../../../services/sisConferenciaApi/tipoRegime/types';



const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig = [
    { key: 'id', displayName: 'ID', width: 300 ,visible:true},
    { key: 'descricao', displayName: 'Descrição',visible:true},
]



export default function TipoRegime() {

    const [tipoRegimes,setTipoRegimes] = useState<ITipoRegime[]>([])


    useEffect(() => {
        

        async function buscarListaTipoRegime() {
            try {
                const result = await apiServiceTipoRegime.listar();
                if (Array.isArray(result)) {
                    setTipoRegimes(result);
                } else {
                    console.error("Result is not an array");
                }
            } catch (error) {
                console.error(error);
            }
        }

        buscarListaTipoRegime();
    }, [])
    
    return (
        <>
            <Breadcrumbs
                current={`Tipo de Regime`}
                prevCrumbs={[{ name: 'Administração' }]}
            />  
            <Titulo titulo={`Tipo de Regime`} voltar={paginaInicial} />

            <TipoRegimeCrud visible={true} tipoRegimes={tipoRegimes} setTipoRegimes={setTipoRegimes} apiService={apiServiceTipoRegime} columnConfig={columnsConfig}></TipoRegimeCrud>
        </>
    )
}

