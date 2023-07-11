import { MUIDataTableColumn } from 'mui-datatables'

export const labelsPt = (loading: boolean | undefined) => {
    return {
        textLabels: {
            body: {
                toolTip: 'Ordenar',
                columnHeaderTooltip: (column: MUIDataTableColumn) => `Ordenar ${column.label}`,
                noMatch: loading ? 'Carregando..' : 'Desculpe, não foi encontrado nenhum registro',
            },
            pagination: {
                next: 'Póxima página',
                previous: 'Página anterior',
                rowsPerPage: 'Registros por página:',
                rowsPerPageOptions: [10, 20, 100],
                displayRows: 'de', // 1-10 of 30
            },
            toolbar: {
                search: 'Pesquisar',
                downloadCsv: 'Download CSV',
                print: 'Imprimir',
                viewColumns: 'Ver colunas',
                filterTable: 'Filtros',
            },
            filter: {
                all: 'TODOS',
                title: 'FILTROS',
                reset: 'resetar',
            },
            viewColumns: {
                title: 'Mostrar Colunas',
                titleAria: 'Mostrar/Esconder Colunas',
            },
            selectedRows: {
                text: 'registro(s) selecionada(s)',
                delete: 'Excluir',
                deleteAria: 'Excluir Registros Selecionados',
            },
        },
    }
}
