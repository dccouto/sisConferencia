import CircularProgress from "@mui/material/CircularProgress";
import { Box, Typography } from "@mui/material";

export function LoadingPage() {
  return (
    <Box
      sx={{
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        flexDirection: "column",
        flexGrow: 1,
      }}
    >
      <Typography>Carregando...</Typography>
      <CircularProgress size={22} color={"secondary"} />
    </Box>
  );
}
