export function fileToArrayBuffer(file: File): Promise<Uint8Array> {
    return new Promise((resolve, reject) => {
      let reader = new FileReader();
  
      reader.onload = event => {
        if (event.target?.result) {
          resolve(new Uint8Array(event.target.result as ArrayBuffer));
        } else {
          reject(new Error('No Result Found'));
        }
      };
  
      reader.onerror = error => reject(error);
  
      reader.readAsArrayBuffer(file);
    });
  }
  
  
export  function arrayBufferToBase64(buffer: any) {
    let binary = '';
    let bytes = new Uint8Array(buffer);
    let len = bytes.byteLength;
    for (let i = 0; i < len; i++) {
      binary += String.fromCharCode(bytes[i]);
    }
    return window.btoa(binary);
  }



 export const getFileAsByteArray = async (file: File): Promise<Uint8Array> => {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.onloadend = () => {
        if (reader.readyState === FileReader.DONE && reader.result) {
          const arrayBuffer = reader.result as ArrayBuffer;
          resolve(new Uint8Array(arrayBuffer));
        } else {
          reject('Failed to read file');
        }
      };
      reader.readAsArrayBuffer(file);
    });
  };
