SELECT F.idFactura AS NumFactura,F.Fecha AS Emitida,C.`Nombre` AS Cliente,
V.`Nombre` AS Vendedor,FP.Saldo,FP.FechaVencimiento,F.TotalFacturado
FROM Factura AS F,FacturasPendientes AS FP, Persona AS C, Persona AS V
WHERE FP.Saldo <>0 AND FP.`idFactura`=F.`idFactura` 
AND F.`idCliente`=C.`idPersona` AND F.`idVendedor`=V.`idPersona` AND F.Fecha BETWEEN ? AND ?;
