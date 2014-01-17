SELECT PCF.idProductoFact AS Codigo,P.Nombre AS Producto,PCF.Cantidad,PCF.PrecioVenta
FROM Producto AS P, ProductoCantidadFact As PCF, Factura AS F
WHERE P.idVersion=PCF.idVersionFact AND P.idProducto=PCF.idProductoFact AND PCF.idFactura = F.idFactura
AND F.idFactura=? AND F.`idVersionFactura`=? AND PCF.idVersionFacturasProducto=F.idVersionFactura;
