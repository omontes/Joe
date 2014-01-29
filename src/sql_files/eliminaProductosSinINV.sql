DELETE producto
FROM producto
WHERE producto.`idProducto` NOT IN(SELECT DISTINCT I.`idProducto`
FROM inventario AS I);
