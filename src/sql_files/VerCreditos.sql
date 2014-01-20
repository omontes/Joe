SELECT F.idFactura, FP.Saldo,FP.FechaVencimiento,F.TotalFacturado,C.Nombre,V.Nombre,F.Tipopago 
FROM Factura AS F,FacturasPendientes AS FP, Persona AS C, Persona AS V
WHERE F.Concepto='Credito' AND F.Estado='A' AND F.idFactura=FP.idFactura AND F.idCliente=C.idPersona AND F.idVendedor=V.idPersona 
AND F.idVersionFactura=FP.idVersionFactPendientes;
