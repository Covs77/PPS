#!/bin/bash
set -e

# Directorio de entrada
INPUT_DIR=${1:-/data/input}

# Directorio de salida
OUTPUT_DIR=${2:-/data/output}

echo "Comprimiremos los archivos de $INPUT_DIR en $OUTPUT_DIR"

# Crear el directorio de salida si no existe
mkdir -p "$OUTPUT_DIR"

# Comprimir cada archivo en el directorio de entrada
for file in "$INPUT_DIR"/*; do
    if [ -f "$file" ]; then
        filename=$(basename -- "$file")
        tar -czf "$OUTPUT_DIR/$filename.tar.gz" -C "$INPUT_DIR" "$filename"
        echo "Archivo $filename comprimido en $filename.tar.gz"
    fi
done
