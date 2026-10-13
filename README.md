## 1. Descripción del problema
El sistema calcula el subtotal de una compra, valida si la operación es válida, determina si aplica un descuento y obtiene el precio final.  
Es importante verificar estos cálculos porque afectan directamente el monto que paga el cliente y la confiabilidad de la aplicación en un entorno de comercio electrónico.

---

## 2. Reglas de negocio
- **Subtotal:** se obtiene multiplicando el precio por la cantidad.
- **Compra válida:** solo se permite si el precio es mayor que cero y la cantidad es mayor que cero.
- **Descuento:** se aplica un 10% cuando el subtotal es mayor o igual a $1,000; si es menor, el descuento es cero.
- **Precio final:** se calcula restando el descuento al subtotal.

---

## 3. Casos de prueba

| Método | Datos de entrada | Resultado esperado | Resultado obtenido | Propósito |
|--------|------------------|--------------------|-------------------|-----------|
| `calculateSubtotal` | (100, 3) | 300.00 | 300.00 | Verificar cálculo básico de subtotal |
| `calculateSubtotal` | (100, 1) | 100.00 | 100.00 | Validar cantidad mínima |
| `calculateSubtotal` | (0, 1) | 0.00 | 0.00 | Confirmar subtotal con precio cero |
| `isValidPurchase` | (100, 3) | true | true | Compra válida |
| `isValidPurchase` | (0, 1) | false | false | Precio cero no válido |
| `isValidPurchase` | (200, 0) | false | false | Cantidad cero no válida |
| `isValidPurchase` | (-200, 2) | false | false | Precio negativo no válido |
| `calculateDiscount` | 999.99 | 0.00 | 0.00 | Subtotal menor a 1000 |
| `calculateDiscount` | 1000.00 | 100.00 | 100.00 | Subtotal igual a 1000 |
| `calculateDiscount` | 1500.00 | 150.00 | 150.00 | Subtotal mayor a 1000 |
| `calculateFinalPrice` | 500.00 | 500.00 | 500.00 | Compra sin descuento |
| `calculateFinalPrice` | 1000.00 | 900.00 | 900.00 | Compra con descuento justo en el límite |
| `calculateFinalPrice` | 1500.00 | 1350.00 | 1350.00 | Compra con descuento aplicado |

---

## 4. Resultados de ejecución
- Total de pruebas: 13  
- Pruebas exitosas: 13  
- Pruebas fallidas: 0

Todas las pruebas pasaron correctamente

---
## 5. Errores que se pueden prevenir
1. **Error de comparación en el descuento:** si se usara `>` en lugar de `>=`, el cliente con subtotal de $1,000 no recibiría el descuento.  
2. **Subtotal incorrecto:** si se olvidara multiplicar precio por cantidad, el sistema devolvería solo el precio unitario.

---

## 6. Conclusión
Las pruebas unitarias garantizan que las reglas de negocio se cumplan de manera consistente. En una aplicación de comercio electrónico, esto asegura que los clientes paguen el monto correcto y que la empresa no pierda ingresos por errores de cálculo.  
Al automatizar las pruebas, se incrementa la confiabilidad del sistema y se facilita la detección temprana de defectos antes de que lleguen a producción.
