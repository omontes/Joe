SELECT F.idFactura,FP.Saldo,F.Fecha AS FechaCreacion,FP.FechaVencimiento,F.TotalFacturado,C.Nombre AS Cliente,V.Nombre AS Vendedor
FROM factura AS F,facturaspendientes AS FP,persona AS C,persona AS V
WHERE F.Concepto='Apartado' AND F.idFactura=FP.idFactura AND F.idCliente=C.idPersona AND F.idVendedor=V.idPersona
ORDER BY F.idFactura DESC LIMIT 100;
