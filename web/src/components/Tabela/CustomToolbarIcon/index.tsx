import { IconButton, Tooltip } from "@mui/material";
import RefreshOutlinedIcon from "@mui/icons-material/RefreshOutlined";
import { queryClient } from "../../../services/queryClient";

interface IToolbarRefreshIconProps {
  queryKey?: string | any[];
}

/**
 * @param queryKey (evita que as outras queries ativas sejam atualizadas também)
 * @constructor
 */
export function ToolbarRefreshIcon({ queryKey }: IToolbarRefreshIconProps) {
  async function handleClick() {
    if (queryKey) {
      await queryClient.refetchQueries(queryKey);
    } else {
      await queryClient.refetchQueries({ active: true });
    }
  }

  return (
    <>
      <Tooltip title="Recarregar dados">
        <IconButton onClick={handleClick}>
          <RefreshOutlinedIcon />
        </IconButton>
      </Tooltip>
    </>
  );
}
