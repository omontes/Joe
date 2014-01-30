SELECT PCM.`idProductoMov`,P.`Nombre`,PCM.`CantidadMovida`,PCM.`PrecioMov`
FROM Producto AS P, ProductoCantidadMovimiento AS PCM, Movimientos AS M
WHERE P.`idVersion`=PCM.`idVersionProdMov`AND P.`idProducto`=PCM.`idProductoMov` AND PCM.`idMovimiento` = M.`idMovimientos`
AND M.`idMovimientos`=?;
