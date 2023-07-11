import {IconButton, Tooltip} from "@mui/material";
import IndeterminateCheckBoxIcon from "@mui/icons-material/IndeterminateCheckBox";
import {DisplayData} from "mui-datatables";

/*
Customização das opções que aparecem ao selecionar as linhas da tabela
 */

interface ICustomToolbarSelectProps {
  selectedRows?: {
    data: Array<{ index: number; dataIndex: number }>;
    lookup: { [key: number]: boolean };
  };
  displayData?: DisplayData;
  setSelectedRows: (rows: number[]) => void;
}

export function CustomToolbarSelect({
  setSelectedRows,
}: ICustomToolbarSelectProps) {
  function handleClickDeselectAll() {
    setSelectedRows([]);
  }

  return (
    <>
      <Tooltip title="Retirar seleção">
        <IconButton onClick={handleClickDeselectAll}>
          <IndeterminateCheckBoxIcon />
        </IconButton>
      </Tooltip>
    </>
  );
}
