import {FormControlProps, GridProps, Stack, Switch, SwitchProps, Typography,} from "@mui/material";
import {Controller, useFormContext} from "react-hook-form";
import {FieldContainer} from "../../FieldContainer";

/*
* Exemplo de uso:
 <RHFSwitch
    name={"status"}
    textBefore={"Não"}
    textAfter={"Sim"}
    outsideLabel={"Listar registros inativos:"}
  />
*/

interface ReactHookFormSwitchProps extends SwitchProps {
  name: string;
  textBefore?: string;
  textAfter?: string;
  outsideLabel?: string;
  formControlProps?: FormControlProps;
  gridProps?: GridProps;
}

export function RHFSwitch({
  name,
  textBefore,
  textAfter,
  outsideLabel,
  formControlProps,
  gridProps,
  ...switchProps
}: ReactHookFormSwitchProps) {
  const { control, getValues } = useFormContext();

  const customGridProps: GridProps = {
    display: "flex" || gridProps?.display,
    alignItems: "center" || gridProps?.alignItems,
    ...gridProps,
  };

  return (
    <FieldContainer
      formControlProps={formControlProps}
      gridProps={customGridProps}
    >
      <Controller
        name={name}
        control={control}
        defaultValue={getValues(name)}
        render={({ field }) => (
          <>
            <Stack direction="row" spacing={0.5} alignItems="center">
              {outsideLabel ? (
                <Typography mr={1.5}>{outsideLabel}</Typography>
              ) : null}
              {textBefore ? <Typography>{textBefore}</Typography> : null}
              <Switch
                color={"secondary"}
                checked={!!field.value}
                {...switchProps}
                {...field}
              />
              {textAfter ? <Typography>{textAfter}</Typography> : null}
            </Stack>
          </>
        )}
      />
    </FieldContainer>
  );
}
