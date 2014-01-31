SELECT I.Cantidad
FROM inventario AS I,producto AS P,ubicacionproducto AS U
WHERE P.idProducto=? AND P.idProducto=I.idProducto AND P.Estado='A' AND I.idUbicacionProducto=U.idUbicacionProducto
AND U.Lugar='Inventario General';
