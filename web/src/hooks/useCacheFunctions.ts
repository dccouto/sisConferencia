import {queryClient} from "../services/queryClient";

/**
 * Para esta função funcionar, o ideal é que o primeiro atributo do objeto seja o id único,
 * ele será usado para comparar, no caso do update e do delete
 * */

export function updateReactQueryCache(
  queryKey: string | unknown[],
  newValue: any,
  remover: boolean = false
) {
  queryClient.setQueryData<any[] | undefined>(queryKey, (previous) => {
    const newValueArray = Object.values(newValue);
    if (previous) {
      let updated;
      if (remover) {
        updated = previous.filter((previousItem) => {
          const previousItemArray = Object.values(previousItem);
          if (previousItemArray[0] === newValueArray[0]) {
            return false;
          }
          return previousItem;
        });
      } else {
        let editar = false;
        updated = previous.map((previousItem) => {
          const previousItemArray = Object.values(previousItem);
          if (previousItemArray[0] === newValueArray[0]) {
            editar = true;
            return { ...previousItem, ...newValue };
          }
          return previousItem;
        });

        if (!editar) {
          return [...previous, newValue];
        }
      }
      return updated;
    }

    return previous;
  });
}
