SELECT M.`Fecha`,M.`ValorMovimiento`,M.`Detalle`,U.`Lugar`
FROM movimientos AS M,ubicacionproducto AS U
WHERE M.`idMovimientos`=? AND M.`idLugarMovimiento`=U.`idUbicacionProducto`;
