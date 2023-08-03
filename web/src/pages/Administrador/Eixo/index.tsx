// Components
import jsonServerProvider from 'ra-data-json-server';
import EixoCrud from './EixoCrud';


// Services

import { useEffect, useState } from 'react';
import { IEixo } from '../../../services/sisConferenciaApi/eventos/types';
import { Grid } from '@mui/material';



const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig = [
    { key: 'id', displayName: 'ID', width: 300 ,visible:true},
    { key: 'descricao', displayName: 'Descrição',visible:true},
]


interface Props {
    listaEixos: IEixo[]
    setEixos: (eixos: IEixo[]) => void
    idEvento:number
}
const Eixo: React.FC<Props> = ({ listaEixos,setEixos,idEvento }) => {
    // 


    useEffect(() => {
        function carregaEixos(){
            setEixos(listaEixos);
        }
            
        carregaEixos();
    }, [])
    
    return (
        <>    
            <EixoCrud visible={true} eixos={listaEixos} setEixos={setEixos}  columnConfig={columnsConfig} contEixos={listaEixos.length + 1} idEvento={idEvento}></EixoCrud>
        </>
    )
}

export default Eixo