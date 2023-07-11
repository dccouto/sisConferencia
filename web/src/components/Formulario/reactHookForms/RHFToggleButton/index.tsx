import {FormControlProps, GridProps, ToggleButton, ToggleButtonGroup, ToggleButtonGroupProps,} from "@mui/material";
import {Controller, useFormContext} from "react-hook-form";
import {FieldContainer} from "../../FieldContainer";

/*
* Exemplo de uso:
   <RHFToggleButton
      name={"status"}
      options={[
        { value: "S", label: "Ativo" },
        { value: "N", label: "Inativo" },
      ]}
    />
* */

interface ReactHookFormSwitchProps extends ToggleButtonGroupProps {
  name: string;
  options: { value: string; label: string | number }[];
  formControlProps?: FormControlProps;
  gridProps?: GridProps;
}

export function RHFToggleButton({
  name,
  options,
  formControlProps,
  gridProps,
  ...togglebuttonProps
}: ReactHookFormSwitchProps) {
  const { control } = useFormContext();
  return (
    <FieldContainer formControlProps={formControlProps} gridProps={gridProps}>
      <Controller
        name={name}
        control={control}
        render={({ field }) => (
          <ToggleButtonGroup
            color={"secondary"}
            exclusive
            sx={{ padding: "4px 0" }}
            {...field}
            {...togglebuttonProps}
          >
            {options.map((option) => (
              <ToggleButton key={option.value} value={option.value}>
                {option.label}
              </ToggleButton>
            ))}
          </ToggleButtonGroup>
        )}
      />
    </FieldContainer>
  );
}
