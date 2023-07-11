import { Grid, IconButton } from "@mui/material";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import MenuIcon from "@mui/icons-material/Menu";
import React from "react";
import { useDrawer } from "../../Drawer/hooks/useDrawer";
import { useAuth } from "../../../../hooks/useAuth";

interface MenuButtonProps {}

export function MenuButton(props: MenuButtonProps) {
  const { openedDrawer, handleOpenDrawer, handleCloseDrawer } = useDrawer();
  const {
    auth: { autenticado },
  } = useAuth();

  if (!autenticado) {
    return null;
    // #AQUI
  }

  return (
    <Grid item>
      <IconButton
        color="secondary"
        size="large"
        edge="end"
        sx={{ mr: 2, visibility: "visible" }}
        aria-label="Menu Lateral"
        onClick={() =>
          openedDrawer ? handleCloseDrawer() : handleOpenDrawer()
        }
      >
        {openedDrawer ? <ChevronLeftIcon /> : <MenuIcon />}
      </IconButton>
    </Grid>
  );
}
