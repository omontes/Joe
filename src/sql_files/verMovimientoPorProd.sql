SELECT M.`Fecha`,M.`Detalle`,T.`Nombre`,U.`Lugar`,PCM.`CantidadMovida`,PCM.`Balance`,PCM.`PrecioMov`
FROM movimientos AS M, productocantidadmovimiento AS PCM,tipomovimiento AS T, ubicacionproducto AS U
WHERE PCM.`idProductoMov`=? AND M.`idMovimientos`=PCM.`idMovimiento`
AND M.`idTipoMovimiento`=T.`idTipoMovimiento` AND M.`idLugarMovimiento`=U.`idUbicacionProducto`;
