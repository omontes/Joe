SELECT PCD.`idProductoDev` AS Codigo,P.Nombre AS Producto,PCD.Cantidad,
PCD.`PrecioDev`
FROM Producto AS P, productocantidaddev As PCD, devolucion AS Dev
WHERE P.idVersion=PCD.`idVersionDev` AND P.idProducto=PCD.`idProductoDev` 
AND PCD.`idDevolucion` = Dev.`idDevolucion`
AND Dev.`idDevolucion`=? AND Dev.`idVersionDev`=? AND
 PCD.`idVersionDevProd`=Dev.idVersionDev;
