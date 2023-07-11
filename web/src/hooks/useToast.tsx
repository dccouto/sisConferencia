import {useSnackbar} from "notistack";


export function useToast() {
  const { enqueueSnackbar, closeSnackbar } = useSnackbar();

  const toastSuccess = (message: string) => {
    const key = enqueueSnackbar(
      message,
      {
        variant: 'success',
        onClick: () => closeSnackbar(key),
      }
    );
  }

  const toastError = (message: string) => {
    const key = enqueueSnackbar(
      message,
      {
        variant: 'error',
        onClick: () => closeSnackbar(key),
      }
    );
  }

  const toastInfo = (message: string) => {
    const key = enqueueSnackbar(
      message,
      {
        variant: 'info',
        onClick: () => closeSnackbar(key),
      }
    );
  }

  const toastWarning = (message: string) => {
    const key = enqueueSnackbar(
      message,
      {
        variant: 'warning',
        onClick: () => closeSnackbar(key),
      }
    );
  }

  const defaultToast = (message: string) => {
    const key = enqueueSnackbar(
      message,
      {
        variant: 'default',
        onClick: () => closeSnackbar(key),
      }
    );
  }

  return { toastSuccess, toastError, toastInfo, toastWarning, defaultToast }
}