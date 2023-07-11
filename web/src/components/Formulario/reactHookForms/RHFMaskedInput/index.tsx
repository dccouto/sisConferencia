import {FieldContainer} from "../../FieldContainer";
import {BaseTextFieldProps, FormControlProps, GridProps, TextField,} from "@mui/material";
import {Controller, useFormContext} from "react-hook-form";
import NumberFormat from "react-number-format";

/*
 * Integração do Mui com react-number-format e react-hook-form
 * https://github.com/s-yadav/react-number-format
 * Recomendada na doc do mui:
 * https://mui.com/pt/components/text-fields/#heading-integration-with-3rd-party-input-libraries
 * */

/*
 * Algumas propriedades do NumberFormat são incompatíveis com as props do TextField
 * Neste CustomProps devemos colocar as props que forem aparecendo como necessidade
 */
type CustomProps = Pick<
  BaseTextFieldProps,
  "onBlur" | "inputProps" | "disabled"
>;

interface RHFMaskedInputProps extends CustomProps {
  name: string;
  label: string;
  format: string;
  isLoading?: boolean;
  allowEmptyFormatting?: boolean;
  formControlProps?: FormControlProps;
  gridProps?: GridProps;
}

export function RHFMaskedInput({
  name,
  label,
  format,
  isLoading,
  allowEmptyFormatting = false,
  formControlProps,
  gridProps,
  ...customProps
}: RHFMaskedInputProps) {
  const {
    formState: { errors },
    control,
  } = useFormContext();

  return (
    <FieldContainer formControlProps={formControlProps} gridProps={gridProps}>
      <Controller
        name={name}
        control={control}
        render={({ field }) => (
          <NumberFormat
            label={label}
            format={isLoading ? "Carregando..." : format}
            allowEmptyFormatting={isLoading ? true : allowEmptyFormatting}
            error={!!errors[name]}
            helperText={errors[name]?.message}
            customInput={TextField}
            inputProps={{
              ...customProps.inputProps,
              style: {
                color: isLoading
                  ? "#6c6c6c"
                  : customProps.inputProps?.style?.color,
              },
            }}
            {...field}
            {...customProps}
          />
        )}
      />
    </FieldContainer>
  );
}
